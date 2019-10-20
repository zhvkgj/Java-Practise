package Tests;

import ObjectsAndClasses.AsciiCharSequence;

public class AsciiCharSequenceTest {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Sequence - " + answer.toString());//Hello!
        System.out.println("Length - " + answer.length());//6
        System.out.println("Character № 1 - " + answer.charAt(1));//e
        System.out.println("Subsequence - " + answer.subSequence(1, 5));//ello
        System.out.println(answer.toString());//Hello!
        System.out.println(example[0] = 74);
        System.out.println(answer.toString());//Hello!
    }
}
