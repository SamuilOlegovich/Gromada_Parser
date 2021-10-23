final class LastName {
    private String value;

    public LastName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || other instanceof LastName && equalTo((LastName) other);
    }

    public boolean equalsTo(LastName other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return 43;
    }
}
