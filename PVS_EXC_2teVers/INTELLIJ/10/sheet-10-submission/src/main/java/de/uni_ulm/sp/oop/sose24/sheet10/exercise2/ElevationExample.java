package de.uni_ulm.sp.oop.sose24.sheet10.exercise2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ElevationExample {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args)
            throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        Configurator.setLevel(logger.getName(), Level.INFO);
        logger.info("starting");

        // load API key
        var path = Paths.get("./google-api-key");
        var apiKey = Files.readAllLines(path).get(0);
        logger.info("API Key: %s".formatted(apiKey));

        // Create HTTP Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://maps.googleapis.com/maps/api/elevation/xml?key=%s&locations=48.42310613454391,9.957252620573465"
                                .formatted(apiKey)))
                .build();
        logger.info("URI: %s".formatted(request.uri()));

        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_1_1)
                .followRedirects(Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpResponse<InputStream> response = client.send(request, BodyHandlers.ofInputStream());

        logger.info("statusCode: %d".formatted(response.statusCode()));

        if (response.statusCode() == HttpURLConnection.HTTP_OK) {
            // parse XML
            var factory = DocumentBuilderFactory.newInstance();
            var builder = factory.newDocumentBuilder();
            var doc = builder.parse(response.body());
            NodeList list = doc.getElementsByTagName("elevation");
            if (list.getLength() == 1) {
                var element = list.item(0);
                System.out.format("the location is at elevation: %sm\n", element.getTextContent());
            } else {
                logger.error("wrong number of elevation elements: %d".formatted(list.getLength()));
            }
        } else {
            logger.error("statusCode: %d".formatted(response.statusCode()));
        }
    }

}
