public class Boss extends Enemy{

    public Boss(String name, Element element, int level) {
        super(name, element, level);
        generateStats(level);
    }

  /*  @Override
    protected void generateStats(int level) {
        stats = new Stats(level); //TODO ändra till boss-specifika stats /Sabina
    }*/  // TODO Jag var tvungen att kommentera ut för att kunna köra mina test, sorry om jag rörde till det /Malin

}
