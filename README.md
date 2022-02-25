# Analyse Java SDK
An official SDK for integrating Analyse into your plugins or servers. (WIP)

## Installation:
1. You'll need to install this repo locally.

## Example Usage:
To begin with, you'll need to initialise the SDK like so:
```java
import net.analyse.sdk.AnalyseSDK;

class AnalyseIntegration {
    public void init() {
        String serverToken = "YOUR-TOKEN";
        String encryptionKey = "YOUR-ENCRYPTION-KEY";

        AnalyseSDK analyseSDK = new AnalyseSDK(serverToken, encryptionKey);
    }
}
```

Once done, you'll have access to the following:
- AnalyseSDK#getServer() - Returns information such as name, uuid, team quota etc.
- AnalyseSDK#sendHeartbeat(players) - Send the current player count to Analyse.
- AnalyseSDK#sendPlayerSession(uuid, username, loginDate, domain, ipAddress, playerStatistics) - Send a logout player session to Analyse.