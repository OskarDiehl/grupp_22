public class Boss extends Enemy{

    public Boss(String name, Element element, int level) {
        super(name, element, level);
        generateStats(level);
    }

    @Override
    protected void generateStats(int level) {
        stats = new Stats(level); //TODO ändra till boss-specifika stats /Sabina
    }
}
