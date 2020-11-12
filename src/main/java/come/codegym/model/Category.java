package come.codegym.model;

public class Category {
    private Long id;
    private String code;

    public Long getId() {
        return id;
    }

    public Category(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
