package gaurav.examples.redis.bloomfilter.service;


public interface UserNameValidatorService {

    boolean checkIfUserNameAvailability(String userName);

}
