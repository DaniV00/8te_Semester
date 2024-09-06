# sheet-8

Sie können, wie auch schon auf den vorherigen Blättern, die Tests wie folgt in der Kommandozeile ausführen:

```bash
./gradlew test -i
```

Alternativ können Sie hierfür auch ihre IDE verwenden.
Sofern Sie noch keine Methode mittels der `@Exercise(task = <nummer>, subTask = <Buchstabe>)` Annotation annotiert haben (z.B. `@Exercise(task = 1, subTask = 'a')`), scheitern selbstverständlich alle Tests.
Wenn eine Aufgabe keine Teilaufgaben besitzt, so können Sie die Angabe des `subTask` weglassen (z.B. `@Exercise(task = 2)`).

Um nur eine Aufgabe zu testen, können Sie entweder die Funktionalität oder folgenden Befehl verwenden (hier als Beispiel für die 2. Aufgabe):

```shell
./gradlew test -i --tests "*exercise2*"
```

Das Übungsblatt für diese Woche sollte um ~6:30 Uhr automatisch auf Moodle veröffentlicht werden.

Wenn Sie interessiert sind, können Sie gerne die von uns bereitgestellten Tests explorieren, allerdings sind Sie momentan bewusst so geschrieben, dass Sie den bisherigen Stoff der Vorlesung übersteigen. Darüber hinaus, sollen diese Tests Ihnen als automatische Überprüfungsmöglichkeit dienen.

Bitte vergessen Sie nicht den Merge Request zu Erstellen (sie können dies auch gerne schon vor Ihrer Abgabe/Bearbeitung machen um die Tests vorab durchlaufen zu lassen).
