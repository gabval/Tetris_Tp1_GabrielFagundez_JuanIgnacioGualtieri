package com.example;

public class Reloj{

    public int tic;

    public Reloj(){

    }

    public int getTic() {
        return tic;
    }

    public void setTic(int tic) {
        this.tic = tic;
    }

    public void tic(){
        setTic(getTic() + 1);
    }
}