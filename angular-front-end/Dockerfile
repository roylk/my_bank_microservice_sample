#Stage 1: compile and build angular codebase

#Using node official latest image
FROM node:latest as build

#Setting the working directory
WORKDIR /usr/local/app

#Adding the source code to the working directory
COPY ./ /usr/local/app

#Installing dependencies
RUN npm install

#Generating the app build
RUN npm run  build

#Stage 2 serving the app with nginx server

#getting official base image
FROM nginx:latest

#copying the build output on the server replacing the default content
COPY --from=build /usr/local/app/dist/angular-front-end /usr/share/nginx/html

#exposing on port 80
EXPOSE 80


