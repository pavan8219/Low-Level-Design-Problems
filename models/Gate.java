package models;

import enums.GateType;

public abstract class Gate {
    public String id;

    public abstract GateType getGateType();

    public Gate(String id){
        this.id=id;
    }
}
