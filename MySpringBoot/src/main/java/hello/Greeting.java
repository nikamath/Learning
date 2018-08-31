package hello;

public class Greeting {

    private Long id;
    private String content;

    public Greeting(){
        super();
    }

    public Greeting(Long id, String content) {
        super();
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
