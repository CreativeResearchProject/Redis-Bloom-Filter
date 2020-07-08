package gaurav.examples.redis.bloomfilter.service.impl;

import gaurav.examples.redis.bloomfilter.service.BloomFilterService;
import gaurav.examples.redis.bloomfilter.service.UserNameValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNameValidatorServiceImpl implements UserNameValidatorService {

    @Autowired
    private BloomFilterService bloomFilterService;

    @Override
    public boolean checkIfUserNameAvailability(String userName) {
        return bloomFilterService.getUserNameBloomFilter().contains(userName);
    }
}
