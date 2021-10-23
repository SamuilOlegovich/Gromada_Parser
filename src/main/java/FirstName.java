final class FirstName {
    private String value;

    public FirstName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || other instanceof FirstName && equalTo((FirstName) other);
    }

    public boolean equalsTo(FirstName other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
