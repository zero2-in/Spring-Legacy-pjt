package dto;

public class MemberDTO {
    private String id, name, area;
    private int age;

    public MemberDTO(String id, String name, String area, int age) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public int getAge() {
        return age;
    }
}
