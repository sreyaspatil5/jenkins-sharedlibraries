def call(Map config = [:]) {
    def imageName  = config.imageName ?: error("Image name is required")
    def imageTag   = config.imageTag ?: 'latest'
    def dockerfile = config.dockerfile ?: "${config.context}/Dockerfile"
    def context    = config.context ?: '.'

    echo "Building Docker image: ${imageName}:${imageTag} using ${dockerfile}"

    sh """
        docker build -t ${imageName}:${imageTag} -f ${dockerfile} ${context}
    """
}
