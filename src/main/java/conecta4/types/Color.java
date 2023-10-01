package conecta4.types;

public enum Color {

    X,
    O,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public static void set(int ordinal) {

    }
    public boolean isNull() {
        return this == Color.NULL;
    }

}