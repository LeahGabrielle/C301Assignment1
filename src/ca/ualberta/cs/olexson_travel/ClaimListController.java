package ca.ualberta.cs.olexson_travel;

import java.io.IOException;

public class ClaimListController {
	
	private static ClaimList claimlist = null;
	static public ClaimList getClaimList() {
		if (claimlist ==null){
			try{
				claimlist = ClaimListManager.getManager().loadClaimlist();
				claimlist.addListener(new Listener()){
					@Override
					public void update(){
						saveClaimList();
					}
				});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException ("Could not deserialize ClaimList from ClaimListManager");	
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not deserialize ClaimList from ClaimListManager");
		}
		}
	}
	
}
