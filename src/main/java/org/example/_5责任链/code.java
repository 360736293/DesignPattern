package org.example._5责任链;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 */
public class code {
    public static void main(String[] args) {
        LeaderChain leaderChain = new LeaderChain();
        Leader leaderNode1 = new Director("张三", 5);
        Leader leaderNode2 = new Manager("李四", 10);
        Leader leaderNode3 = new GeneralManager("王五", 15);
        leaderChain.addChain(leaderNode1).addChain(leaderNode2).addChain(leaderNode3);
        LeaveRequest leaveRequest = new LeaveRequest("小明", 6, "回家探亲");
        leaderChain.handleChain(leaveRequest);
    }
}

class LeaderChain {
    private List<Leader> chain = new ArrayList<>();

    public LeaderChain addChain(Leader leader) {
        this.chain.add(leader);
        return this;
    }

    public void handleChain(LeaveRequest leaveRequest) {
        for (Leader leader : chain) {
            if (leaveRequest.getLeaveDays() <= leader.getDayNum()) {
                System.out.println("领导：" + leader.getName() + "，批假最大天数：" + leader.getDayNum() + "，审批通过");
                return;
            } else {
                System.out.println("领导：" + leader.getName() + "，批假最大天数：" + leader.getDayNum() + "，无审批权限，交由下一个领导审批");
            }
        }
    }
}

class Leader {
    private String name;
    private Integer dayNum;

    public Leader(String name, Integer dayNum) {
        this.name = name;
        this.dayNum = dayNum;
    }

    public String getName() {
        return this.name;
    }

    public Integer getDayNum() {
        return this.dayNum;
    }
}

class Director extends Leader {
    public Director(String name, Integer dayNum) {
        super(name, dayNum);
    }
}

class Manager extends Leader {
    public Manager(String name, Integer dayNum) {
        super(name, dayNum);
    }
}

class GeneralManager extends Leader {
    public GeneralManager(String name, Integer dayNum) {
        super(name, dayNum);
    }
}

class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String reason;

    public LeaveRequest(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
        System.out.println("员工：" + this.empName + "，请假天数：" + this.leaveDays + "，理由：" + this.reason);
    }

    public String getEmpName() {
        return empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public String getReason() {
        return reason;
    }
}





