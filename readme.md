### ELB not able to connect to Container
- Add Rule in security group for tcp connection

### Can't push image to Amazon ECR - fails with "no basic auth credentials"

aws ecr get-login --region us-east-1
This command returned a big blob, which includes the docker login command right there! I didn't realise. It should return something like this:

docker login -u AWS -p <your_token_which_is_massive> -e none <your_aws_url>
Copy and paste this command & then run your docker push command which looks something like this:

docker push 8888888.blah.blah.ap-southwest-1.amazonaws.com/dockerfilenameaws ecr get-login --region ap-southeast-2
This command returned a big blob, which includes the docker login command right there! I didn't realise. It should return something like this:

docker login -u AWS -p <your_token_which_is_massive> -e none <your_aws_url>
Copy and paste this command & then run your docker push command which looks something like this:

docker push 8888888.blah.blah.ap-southwest-1.amazonaws.com/dockerfilename