/*
 * Program: PresidentList
 * This:  President.java
 * Date: 3/28/2016
 * Author: S. Hostetler
 * Purpose: To create an object to store data on a president.
 */
package presidentlist;

public class President 
{
    private int order;
    private String firstName;   // = "George";
    private String lastName;    // = "Washington";
    private String birthDate;   // = "02/22/1732";
    private String birthState;  // = "Virginia";
    private String termStart;   // = "1789";
    private String termEnd;     // = "1797";
    private String party;       // = "none";
    private String vpFirst;     // = "John";
    private String vpLast;      // = "Adams";
    
    public President()
    {
        
    }
    

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getTermStart() {
        return termStart;
    }

    public void setTermStart(String termStart) {
        this.termStart = termStart;
    }

    public String getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(String termEnd) {
        this.termEnd = termEnd;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getVpFirst() {
        return vpFirst;
    }

    public void setVpFirst(String vpFirst) {
        this.vpFirst = vpFirst;
    }

    public String getVpLast() {
        return vpLast;
    }

    public void setVpLast(String vpLast) {
        this.vpLast = vpLast;
    }

    @Override
    public String toString() 
    {
        String output;
        output = String.format("%-3d%-12s%-12s%-12s%-15s%-6s%-6s%-23s%-12s%-12s",
            order,firstName,lastName,birthDate,birthState,termStart,termEnd,
            party,vpFirst,vpLast);
        return output;
    }
    
    
    
    
    
}
