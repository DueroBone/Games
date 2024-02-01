

public class Board {
    Property[] properties = new Property[40];
    MonopolyGame game;
    ActionsDeck chance = new ActionsDeck(SpecialProperty.SpecialPropertyType.CHANCE);
    ActionsDeck communityChest = new ActionsDeck(SpecialProperty.SpecialPropertyType.COMMUNITY_CHEST);

    public Board() {
        properties[0] = new SpecialProperty("Go", this);
        properties[1] = new Property("Mediterranean Avenue", 60, 2, 30, this);
        properties[2] = new SpecialProperty("Community Chest", this);
        properties[3] = new Property("Baltic Avenue", 60, 4, 30, this);
        properties[4] = new Property("Income Tax", 0, 0, 0, this);
        properties[5] = new Property("Reading Railroad", 200, 25, 100, this);
        properties[6] = new Property("Oriental Avenue", 100, 6, 50, this);
        properties[7] = new SpecialProperty("Chance", this);
        properties[8] = new Property("Vermont Avenue", 100, 6, 50, this);
        properties[9] = new Property("Connecticut Avenue", 120, 8, 60, this);
        properties[10] = new SpecialProperty("Jail", this);
        properties[11] = new Property("St. Charles Place", 140, 10, 70, this);
        properties[12] = new Property("Electric Company", 150, 0, 75, this);
        properties[13] = new Property("States Avenue", 140, 10, 70, this);
        properties[14] = new Property("Virginia Avenue", 160, 12, 80, this);
        properties[15] = new Property("Pennsylvania Railroad", 200, 25, 100, this);
        properties[16] = new Property("St. James Place", 180, 14, 90, this);
        properties[17] = new SpecialProperty("Community Chest", this);
        properties[18] = new Property("Tennessee Avenue", 180, 14, 90, this);
        properties[19] = new Property("New York Avenue", 200, 16, 100, this);
        properties[20] = new SpecialProperty("Free Parking", this);
        properties[21] = new Property("Kentucky Avenue", 220, 18, 110, this);
        properties[22] = new SpecialProperty("Chance", this);
        properties[23] = new Property("Indiana Avenue", 220, 18, 110, this);
        properties[24] = new Property("Illinois Avenue", 240, 20, 120, this);
        properties[25] = new Property("B. & O. Railroad", 200, 25, 100, this);
        properties[26] = new Property("Atlantic Avenue", 260, 22, 130, this);
        properties[27] = new Property("Ventnor Avenue", 260, 22, 130, this);
        properties[28] = new Property("Water Works", 150, 0, 75, this);
        properties[29] = new Property("Marvin Gardens", 280, 24, 140, this);
        properties[30] = new SpecialProperty("Go To Jail", this);
        properties[31] = new Property("Pacific Avenue", 300, 26, 150, this);
        properties[32] = new Property("North Carolina Avenue", 300, 26, 150, this);
        properties[33] = new SpecialProperty("Community Chest", this);
        properties[34] = new Property("Pennsylvania Avenue", 320, 28, 160, this);
        properties[35] = new Property("Short Line", 200, 25, 100, this);
        properties[36] = new SpecialProperty("Chance", this);
        properties[37] = new Property("Park Place", 350, 35, 175, this);
        properties[38] = new Property("Luxury Tax", 0, 0, 0, this);
        properties[39] = new Property("Boardwalk", 400, 50, 200, this);
    }

    public void printBoard() {
        System.out.println("------------------------------------------------------------------");
        System.out.println(properties[0].owner.name + " | " + properties[1].owner.name + " | "
                + properties[2].owner.name
                + " | " + properties[3].owner.name + " | " + properties[4].owner.name + " | " + properties[5].owner.name
                + " | "
                + properties[6].owner.name + " | " + properties[7].owner.name + " | " + properties[8].owner.name + " | "
                + properties[9].owner.name + " | " + properties[10].owner.name);
        System.out.println(properties[39].owner.name
                + "                                                                     "
                + properties[11].owner.name);
        System.out.println(properties[38].owner.name
                + "                                                                     "
                + properties[12].owner.name);
        System.out.println(properties[37].owner.name
                + "                                                                     "
                + properties[13].owner.name);
        System.out.println(properties[36].owner.name
                + "                                                                     "
                + properties[14].owner.name);
        System.out.println(properties[35].owner.name
                + "                                                                     "
                + properties[15].owner.name);
        System.out.println(properties[34].owner.name
                + "                                                                     "
                + properties[16].owner.name);
        System.out.println(properties[33].owner.name
                + "                                                                     "
                + properties[17].owner.name);
        System.out.println(properties[32].owner.name
                + "                                                                     "
                + properties[18].owner.name);
        System.out.println(properties[31].owner.name
                + "                                                                     "
                + properties[19].owner.name);
        System.out.println(properties[30].owner.name + " | "
                + properties[29].owner.name + " | " + properties[28].owner.name + " | " + properties[27].owner.name
                + " | "
                + properties[26].owner.name + " | " + properties[25].owner.name + " | " + properties[24].owner.name
                + " | "
                + properties[23].owner.name + " | " + properties[22].owner.name + " | " + properties[21].owner.name
                + " | "
                + properties[20].owner.name);
        System.out.println("------------------------------------------------------------------");
    }
}
