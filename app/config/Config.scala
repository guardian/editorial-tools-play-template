package config

import com.amazonaws.auth.{AWSCredentialsProviderChain, InstanceProfileCredentialsProvider}
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.regions.Region
import play.api.Configuration
import services.AwsInstanceTags

class Config(conf: Configuration) extends AwsInstanceTags {

  val stage: String = readTag("Stage") getOrElse "DEV"
  val appName: String = readTag("App") getOrElse "atom-workshop"
  val stack: String = readTag("Stack") getOrElse "flexible"
  val region: Region = services.EC2Client.region

  val awsCredentialsProvider = new AWSCredentialsProviderChain(
    new ProfileCredentialsProvider("composer"),
    new InstanceProfileCredentialsProvider(false)
  )


  val pandaDomain: String = conf.get[String]("panda.domain")
  val pandaSystem: String = conf.get[String]("panda.system")
  val pandaAuthCallback: String = conf.get[String]("panda.authCallback")

  val elkKinesisStream: String = conf.getOptional[String]("elk.kinesis.stream").getOrElse("")
  val elkLoggingEnabled: Boolean = conf.getOptional[Boolean]("elk.logging.enabled").getOrElse(false)

}
