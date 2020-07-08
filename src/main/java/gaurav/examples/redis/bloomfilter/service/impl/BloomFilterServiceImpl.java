package gaurav.examples.redis.bloomfilter.service.impl;

import gaurav.examples.redis.bloomfilter.service.BloomFilterService;
import lombok.Synchronized;
import lombok.extern.log4j.Log4j2;
import org.ajbrown.namemachine.NameGenerator;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class BloomFilterServiceImpl implements BloomFilterService {

    @Autowired
    private RedissonClient redissonClient;

    private RBloomFilter<String> userNameBloomFilter;


    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void loadAllDataInBloomFilter() {
        RBloomFilter<String> stringRBloomFilter = getUserNameBloomFilter();

        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generateNames(9999).forEach(name -> {
            log.info("Name generated - " + name.getFirstName());
            stringRBloomFilter.add(name.getFirstName());
        });
    }

    @Override
    @Synchronized
    public RBloomFilter<String> getUserNameBloomFilter() {
        if (null == userNameBloomFilter) {
            RBloomFilter<String> stringRBloomFilter = redissonClient.getBloomFilter("usernames");
            stringRBloomFilter.tryInit(99999, 0.001);
            userNameBloomFilter = stringRBloomFilter;
        }

        return userNameBloomFilter;
    }
}
