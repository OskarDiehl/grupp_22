public class Character {
    private String name;
    private Element element;

    public Character(String name, Element element){
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public Element getElement() {
        return element;
    }
}
