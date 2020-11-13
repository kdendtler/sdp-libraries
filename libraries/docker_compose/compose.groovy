package docker_compose

void call(){

}

void up() {
    node {
        stage("Deploy") {
            String command = "docker-compose "

            if (config.args) {
                config.args.each { arg -> command += " ${arg} "}
            }

            config.files.each { file -> command += " -f ${file} " }
            command += "up -d"

            sh command

            if (config.sleep) {
                sleep time: config.sleep.time, unit: config.sleep.unit
            }
        }
    }
}

void down() {
    node {
        stage("Teardown") {
            String command = "docker-compose "

            if (config.args) {
                config.args.each { arg -> command += " ${arg} "}
            }

            config.files.each { file -> command += " -f ${file} " }
            command += "down"

            sh command

        }
    }
}