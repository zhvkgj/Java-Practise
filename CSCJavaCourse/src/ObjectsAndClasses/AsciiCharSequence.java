package ObjectsAndClasses;

public class AsciiCharSequence implements CharSequence {
    private byte[] value;

    public AsciiCharSequence(byte[] init) {
        value = init.clone();
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int i) {
        return (char) value[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] subSeq = new byte[i1 - i];
        for (int j = i; j < i1; j++) {
            subSeq[j - i] = value[j];
        }
        return new AsciiCharSequence(subSeq);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this).toString();
    }
}
