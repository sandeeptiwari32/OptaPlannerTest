public class Vadiya {

	public Vadiya(String name, Integer period) {
		this.period = period;
		this.name = name;
	}
	
    private String name;
    private Integer period;

    public Integer getPeriod() {
        return period;
    }

    public String getVadiyaName() {
        return name;
    }

}