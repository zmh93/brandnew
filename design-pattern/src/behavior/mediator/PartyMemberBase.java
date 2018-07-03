package behavior.mediator;

/**
 * Abstract base class for party members.
 */
public abstract class PartyMemberBase implements PartyMember {

    protected Party party;

    @Override
    public void joinedParty(Party party) {
        System.out.printf("%s joins the party\n", this);
        this.party = party;
    }

    @Override
    public void partyAction(Action action) {
        System.out.printf("%s %s \n", this, action.getDescription());
    }

    @Override
    public void act(Action action) {
        if (party != null) {
            System.out.printf("%s %s \n", this, action);
            party.act(this, action);
        }
    }

    @Override
    public abstract String toString();

}
