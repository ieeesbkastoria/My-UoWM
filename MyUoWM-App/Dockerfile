# Build and run the image by using:
# docker compose up -d --build

# Use an official Node runtime as the base image
FROM node:20-alpine AS build

# Set the working directory in the container to /app
WORKDIR /app

# Install dependencies first to leverage Docker cache
COPY package*.json .

# Using cache mount for npm install, so unchanged packages aren’t downloaded every time
RUN --mount=type=cache,target=/root/.npm \
    npm install

# Bundle app source inside Docker image it excludes files in .dockerignore
COPY . .

# Build the app
RUN npm run build

# Use Nginx as the production server
FROM nginx:alpine

# Copy the built React app to Nginx's web server directory
COPY --from=build /app/build /usr/src/app
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
# Expose port 80 for the Nginx server
EXPOSE 80

# Start Nginx when the container runs
CMD ["nginx", "-g", "daemon off;"]
