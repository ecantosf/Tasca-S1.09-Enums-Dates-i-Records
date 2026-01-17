package enums;

public class Task {
    private String name;
    private Level priority;
    private String description;

    public Task(String name, Level priority, String description) {
        this.name = name;
        this.priority = priority;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getPriority() {
        return priority;
    }

    public void setPriority(Level priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void processTask(){
        System.out.println("\nProcessing task: " + name);
        System.out.println("Description: " + description);

        switch (priority) {
            case LOW:
                System.out.println("Priority: LOW - This task can be done later.");
                System.out.println("Estimated time: 30 minutes");
                System.out.println("Assigned to: Junior team member");
                break;

            case MEDIUM:
                System.out.println("Priority: MEDIUM - This task should be completed soon.");
                System.out.println("Estimated time: 2 hours");
                System.out.println("Assigned to: Regular team member");
                break;

            case HIGH:
                System.out.println("Priority: HIGH - This task requires immediate attention!");
                System.out.println("Estimated time: As soon as possible");
                System.out.println("Assigned to: Senior team member or manager");
                System.out.println("Alert: Send notification to all team members");
                break;
        }

    }
}
