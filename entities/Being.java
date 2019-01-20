package entities;

public abstract class Being {

    public Being(int code, String name) {
        this.code = code;
        this.name = name;
    }
    protected int code;
    protected String name;
}

