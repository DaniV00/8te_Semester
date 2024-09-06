package exercise3;

import exercise3.MessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeneGesseritCodeTest {
    private static final Method identifyMethod = TestUtil.findAnnotatedMethod(3, 'a');
    private static final Method extractMethod = TestUtil.findAnnotatedMethod(3, 'b');

    private static final Random rand = new Random();
    private static final char[] sonderzeichen = new char[]{'@','#','$','%','^','&','*'};

    private static final String extractWarningPattern = "^([\\w-]+)\\s*\\(([A-Z]+)\\)->([\\w-]+)";

    @Test
    void testIdentifyType() throws InvocationTargetException, IllegalAccessException {
        if(identifyMethod == null)Assertions.fail("Method to be tested not found");


        var valuesMeeting = constructMeeting(rand.nextInt(20,60));
        var valuesWarning = constructWarning(rand.nextInt(20,60));
        var valuesMessage = constructMessage(rand.nextInt(20,60));
        for (var value : valuesMeeting) {
            Assertions.assertEquals(MessageType.Meeting, identifyMethod.invoke(null, value));
        }

        for (var value : valuesWarning) {
            Assertions.assertEquals(MessageType.Warning, identifyMethod.invoke(null, value));
        }

        for (var value : valuesMessage) {
            Assertions.assertEquals(MessageType.Message, identifyMethod.invoke(null, value));
        }
    }

    @Test
    void testExtractType() throws InvocationTargetException, IllegalAccessException {
        if(extractMethod == null)Assertions.fail("Method to be tested not found");

        var messages = new ArrayList<String>(){{
            add("#ABC1234@#xyz:    Harkonnen-Spy (DANGER)->protocol_17");
            add("#AFZ1644@#xyz: Spice-Jedis (MILD)->protocol_66");
            add("#FCK3614@#xyz:   Cyberpsycho    (DANGER)->max_tac");
            add("#WTH3234@#xyz:   Wild-Hunt   (CATASTROPHE)->protocol_gwent");
            add("#ABC0034@&xyz: Friendly-Fire(NONE)->forget_about_it");
            add("#CAK3000*#xyz:Cake   (DISAPPOINTMENT)->its_a_lie");
        }};

        for (var value : messages) {
            var expected = extractWarningDetailsHelper(value);
            var actual = extractMethod.invoke(null, value);
            Assertions.assertEquals(expected, actual);
        }
    }

    private static List<String> constructMeeting(int amount){
        var results = new ArrayList<String>();
        for(int i = 0; i < amount; i++){
            String message = "#" + constructRandomAscii(3, 48, 58) + "-" + constructRandomAscii(2, 48, 58) + "-" + constructRandomAscii(4, 48, 58) + ": " + constructRandomBody();
            results.add(message);
        }
        return results;
    }

    private static List<String> constructWarning(int amount){
        var results = new ArrayList<String>();
        for(int i = 0; i < amount; i++){
            String prefix = "#" + constructRandomAscii(3, 65, 91) + constructRandomAscii(4, 48, 58);
            String message = prefix + sonderzeichen[rand.nextInt(sonderzeichen.length)] + sonderzeichen[rand.nextInt(sonderzeichen.length)] + constructRandomAscii(3, 97, 123) + ": " + constructRandomBody();
            results.add(message);
        }
        return results;
    }

    private static List<String> constructMessage(int amount){
        var results = new ArrayList<String>();
        for(int i = 0; i < amount; i++){
            String message = "#" + constructRandomHex(6) + ": " + constructRandomBody();
            results.add(message);
        }
        return results;
    }

    private static String constructRandomBody(){
        int length = rand.nextInt(3, 10);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(rand.nextInt(100) % 2 == 0){
                result.append(constructRandomHex(rand.nextInt(3,10)));
            }else{
                result.append(constructRandomAscii(rand.nextInt(3,10), 97, 137));
            }
            result.append(" ");
        }
        return result.toString();
    }

    // upper is exclusive bound
    private static String constructRandomAscii(int length, int lower, int upper){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++){
            result.append((char)rand.nextInt(lower,upper));
        }
        return result.toString();
    }

    private static String constructRandomHex(int length){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++){
            result.append(Integer.toHexString(rand.nextInt(16)).toUpperCase());
        }
        return result.toString();
    }

    public static Map<String, String> extractWarningDetailsHelper(String message){
        var body = message.split(":")[1].trim();
        var results = new HashMap<String, String>();
        Pattern pattern = Pattern.compile(extractWarningPattern);
        Matcher matcher = pattern.matcher(body);

        if(matcher.matches()){
            results.put("Topic", matcher.group(1));
            results.put("Level", matcher.group(2));
            results.put("Reaction", matcher.group(3));
        }
        return results;
    }
}
