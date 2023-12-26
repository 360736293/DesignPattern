package org.example._5责任链;

/**
 * 责任链模式
 */
public class code {
    public static void main(String[] args) {
        Leader leader = new Director("张三", 5);
        Leader leader1 = new Manager("李四", 10);
        Leader leader2 = new GeneralManager("王五", 15);
        leader.setNextLeader(leader1);
        leader1.setNextLeader(leader2);

        LeaveRequest leaveRequest = new LeaveRequest("小明", 6, "回家探亲");
        leader.handleRequest(leaveRequest);
    }
}

class Leader {
    private String name;
    private Integer dayNum;
    private Leader nextLeader;

    public Leader() {
    }

    public Leader(String name, Integer dayNum) {
        this.name = name;
        this.dayNum = dayNum;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays() <= this.dayNum) {
            System.out.println("领导：" + this.name + "审批通过");
        } else {
            if (this.nextLeader != null) {
                System.out.println("领导：" + this.name + " 无审批权限，交由 " + this.nextLeader.name + " 审批");
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}

class Director extends Leader {
    public Director() {
    }

    public Director(String name, Integer dayNum) {
        super(name, dayNum);
    }
}

class Manager extends Leader {
    public Manager() {
    }

    public Manager(String name, Integer dayNum) {
        super(name, dayNum);
    }
}

class GeneralManager extends Leader {
    public GeneralManager() {
    }

    public GeneralManager(String name, Integer dayNum) {
        super(name, dayNum);
    }
}

class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String reason;

    public LeaveRequest() {
    }

    public LeaveRequest(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
        System.out.println("员工：" + this.empName + "请假 天数：" + this.leaveDays + " 理由：" + this.reason);
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





