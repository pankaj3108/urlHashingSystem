# Assumption

Our system will be read-heavy. user will get original url from database compared to hashing the original url.
I am assuming a 10:1 ratio between read and write.

#Traffic estimates: 
Assuming, we will have 10M new url hashing per day, with 10:1 read/write ratio, we can expect about 100M/day get method operation.

In my application, I have generated hashKey of length 6 to store original url in database. hashKey will be generated using [a-z 0-9]
which will generate 35^6 keys which is approximetaly 10^9 keys which 1000M ~ 1B keys which will accomadate our assumed hashing requests beacuse as we are retaining hashKeys for 7 days and each day we are getting 10M requests that means at any point time our database at most 70M unique hashes.

#Total estimated queries per second for system:
10 million/(24 hours*3600 seconds) = ~ 120 URLs/second

#Considering 10:1 read/write ratio, URLs redirection will be:
10*4 = 1.2K/s

I am assuming that the Long Url which will be stored in the database will itself conatin UTM tracking metadata.

