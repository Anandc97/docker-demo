# docker-demo
docker build instructions are given in DockerFile

build image -  
docker build -t image_name .

run image -  
docker run -dp 3000:3000 --name app-name image_name --server.port=3000

to run with volume -  
docker run -v storage_path_for_the_volume_to_be_mounted:/var/file -dp 2000:2000 --name app-name image_name --server.port=2000
