package gaurav.examples.redis.bloomfilter.service;

import org.redisson.api.RBloomFilter;

public interface BloomFilterService {

    void loadAllDataInBloomFilter();

    RBloomFilter<String> getUserNameBloomFilter();
}
