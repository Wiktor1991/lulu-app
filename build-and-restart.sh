docker build . -t luluapp
docker stop luluapp || true
docker rm luluapp || true
docker run -d -p 8080:8080 --name=luluapp luluapp --network lulu --restart unless-stopped