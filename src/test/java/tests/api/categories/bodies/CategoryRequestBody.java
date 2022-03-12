package tests.api.categories.bodies;

public class CategoryRequestBody {

    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public CategoryRequestBody() {
    }

    // used for post and patch requests
    public CategoryRequestBody(String id, String name) {
        setId(id);
        setName(name);
    }

    // used for all fields
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
