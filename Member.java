public class Member {
    private String name;
    private int memberId;
    private static int idCounter = 1;

    public Member(String name) {
        this.name = name;
        this.memberId = idCounter++;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ")";
    }
}
