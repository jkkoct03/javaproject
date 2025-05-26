package interviewTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.stream.events.Characters;

public class Test2 {
    public static void main(String[] args) {
        String str = "My name is Jay Jay is lcoated bangalore bangalore is karanatka";
        Map<String, Long> frequencyOfWords = Stream.of(str.split(" "))
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue() == 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(frequencyOfWords);

        String firstFrequencyOfWords = Stream.of(str.split(" "))
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue() == 1).findFirst().get().getKey();

        System.out.println(firstFrequencyOfWords);

         String str1 = "asfAGafeYwev";
        Map<Object, Long> mapStr = str1.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(ch->(char)ch, LinkedHashMap::new, Collectors.counting()));
        System.out.println(mapStr);

        Map<Character, Long> mapStr1 = str1.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

     System.out.println(mapStr1);

    }
}
