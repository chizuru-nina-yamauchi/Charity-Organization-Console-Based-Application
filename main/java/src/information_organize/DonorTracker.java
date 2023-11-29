package information_organize;

import java.util.HashMap;

public class DonorTracker {
    private final HashMap<Integer, Donor > donorObjects;

    public DonorTracker() {

        donorObjects =  new HashMap<>();
    }

    public void addDonorDetails(int donorID, Donor donor){
        donorObjects.put(donorID, donor);
    }

    public void deleteDonorDetails(int donorID){
        donorObjects.remove(donorID);
    }

    //implement the method of containsDonor to check if the donor ID exist or there is no donor ID that the users entered.
    public boolean hasDonorID(int donorID){

        return donorObjects.containsKey(donorID);
    }

    public Donor getDonorByID(int donorID){
        return donorObjects.getOrDefault(donorID, null);
    }

    public void displayAllTheDonors(){
        for(Donor donor : donorObjects.values()){
            System.out.println(donor.toString());
        }
    }

}
