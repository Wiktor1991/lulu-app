docker build . -t luluapp
docker stop luluapp
docker rm luluapp
docker run -d -p 8080:8080 --name=luluapp luluapp