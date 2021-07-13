package entity;

public abstract class FantasyCharacter implements Fighter{

    private String name;

    private int healthPoints;
    private int strength;
    private int dexterity;

    private int skill;
    private int gold;
    //Конструктор
    public FantasyCharacter(String name, int healthPoints, int strength, int dexterity, int skill, int gold) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.skill = skill;
        this.gold = gold;
    }
    //Метод для ведения боя
    @Override
    public int attack() {
        if (dexterity * 3 > getRandomValue()) return strength;
        else return  0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getSkill() {
        return skill;
    }
    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }
    //Переопределяем вывод в консоль, чтобы выводилось имя и очки здоровья
    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, healthPoints);
    }
}
