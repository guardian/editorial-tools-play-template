#Atom Workshop

A single tool for all atom types.

## Running locally

You'll need the [AWS CLI](http://docs.aws.amazon.com/cli/latest/userguide/installing.html) installed,
and credentials for the composer AWS account from [janus](https://janus.gutools.co.uk). Then:

 - Fetch config from S3: `./fetch-config.sh`
 - Run using sbt: `sbt run`