version: '3.8'

networks:
  custom-network:
    driver: bridge
    ipam:
      config:
        - subnet : 172.30.0.0/24
          gateway : 172.30.0.1

services:
  db:
    image: db
    build:
      context: ./DB
      dockerfile: Dockerfile
    container_name: db-container
    networks:
      custom-network:
        ipv4_address: 172.30.0.10
    healthcheck:
      test: [ "CMD", "mysqladmin", "ping", "-h", "127.0.0.1" ]
      interval: 30s
      timeout: 10s
      retries: 5          
    ports:
      - "3330:3306"
    environment:
      MYSQL_ROOT_PASSWORD: Zhfldk11!
      MYSQL_DATABASE: testdb
      MYSQL_USER: dbconn
      MYSQL_PASSWORD: Zhfldk11!
      MYSQL_ROOT_HOST: '%' 
    volumes:
      # - ./DB/init.sql:/docker-entrypoint-initdb.d/init.sql
      - db-data:/var/lib/mysql           
  
  redis:
    image: redis
    build:
      context: ./REDIS
    container_name: redis-container
    ports:
      - "6380:6379"
    networks:
      custom-network:
        ipv4_address: 172.30.0.20  
  fn:
    image: fn
    build:
      context: ./FN
    container_name: fn-container
    ports:
      - "3000:80"
    depends_on:
      bn:
        condition: service_healthy
    networks:
      custom-network:
        ipv4_address: 172.30.0.30 

  bn:
    image: bn
    build:
      context: ./BN
    container_name: bn-container
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db-container:3306/testdb
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: Zhfldk11!
      SPRING_REDIS_HOST: redis
      SERVER_PORT: 8080

    healthcheck:
      test: ["CMD-SHELL", "curl -f  http://127.0.0.1:8080/actuator/health"]
      interval: 30s
      timeout: 10s
      retries: 5

    depends_on:
      db:
        condition: service_healthy

    networks:
      custom-network:
        ipv4_address: 172.30.0.40  

  jenkins:
    image: jenkins
    build:
      context: ./JENKINS
    container_name: jenkins-container
    ports:
      - "9090:8080"
      - "50000:50000"
    volumes:
      - jenkins-data:/var/jenkins_home
      - /var/run/docker.sock:/var/run/docker.sock
    networks:
      - custom-network
        
volumes:
  db-data:
  jenkins-data: