package org.example.learnsmashers.Project10;

public class IsPrime {
    private int num;

    public IsPrime(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean check() {
        if (this.num == 2 || this.num == 3)
            return true;

        for (int i = this.num - 1; i > 3; i--) {
            if (this.num % i == 0)
                return false;
        }
        return true;
    }
}
