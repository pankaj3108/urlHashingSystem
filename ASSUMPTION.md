# Assumption

Our system will be read-heavy. user will get original url from database compared to short url.
I am assuming a 100:1 ratio between read and write.

#Traffic estimates: 
Assuming, we will have 100M new url shortening per month, with 100:1 read/write ratio, we can expect about 10B get method operation.

In my application, I have generated hashKey of length 6 to store original url in database. hashKey will be generated using [a-z 0-9]
which will generate 35^6 keys which is approximetaly 10^9 keys which 1000M ~ 1B keys which will accomadate our assumed shortening requests.

#Total estimated queries per second for system:
100 million/(30 days*24 hours*3600 seconds) = ~ 40 URLs/second

#Considering 100:1 read/write ratio, URLs redirection will be:
100*40 = 4K/s

# I am assuming that the Long Url which will be stored in the database will itself conatin UTM tracking metadata.

