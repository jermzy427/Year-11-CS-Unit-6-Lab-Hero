public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent){
        double random = Math.random();
        if(random < 0.50){
            opponent.hitPoints = opponent.hitPoints - 10 ;
        }else if(random > 0.50){
            this.hitPoints = this.hitPoints -10;
        }

    }

    public void senzuBean(){
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        for( int i = 0 ; this.hitPoints > i;){
            this.attack(opponent);
        }
    }


    public String fightUntilTheDeath(Hero opponent){
        opponent.senzuBean();
        this.senzuBean();
        this.fightUntilTheDeathHelper(opponent);
        return(this.name +": " + this.hitPoints + "\n" + opponent.name + ": " + opponent.hitPoints);
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] score = new int[n];
        for(int i = 0 ; i < n; i++){
            while(this.hitPoints > 0 || opponent.hitPoints > 0){
               attack(opponent);
            }
            if(getHitPoints() == 0){
                score[i] = 1;
            }
            if (opponent.getHitPoints() == 0){
                score[i] = 0;
            }
            senzuBean();
            opponent.senzuBean();
        }
        return score;
    }

    public String nFightsToTheDeath(Hero opponent , int n){
        int p1counter = 0;
        int p2counter = 0;
        int[] counter = this.nFightsToTheDeathHelper(opponent,n);
        String winner;
        for(int i : counter){
            if (i == 0) {
                p1counter++;
            }
            else if (i==1) {
                p2counter++;
            }
        }
        if(p1counter > p2counter){
            winner = getName() + "wins!";
        }
        else if (p1counter < p2counter) {
            winner = opponent.getName() + "wins!";
        }
        else {
            winner = "OMG! It was actually a draw!";
        }
        return getName() + ": " + p1counter+" wins\n"+ opponent.getName()+ ": " + p2counter+" wins\n" +winner;
    }

    public void dramaticFightToTheDeath(Hero opponent){
        String winner;
        senzuBean();
        opponent.senzuBean();
        while(getHitPoints() > 0 || opponent.getHitPoints() > 0){
            fightUntilTheDeathHelper(opponent);
            System.out.println(getName()+": " + getHitPoints()+
                     opponent.getName() + ": " + opponent.getHitPoints());
        }
        if(getHitPoints() > opponent.getHitPoints()){
            winner = getName() + "wins!";
        }
        else if (getHitPoints() < opponent.getHitPoints()) {
            winner = opponent.getName() + "wins!";
        }
    }
}
