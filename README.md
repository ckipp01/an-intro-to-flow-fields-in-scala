# An intro to Flow Fields in Scala

This repo holds the code necessary to run the examples in [this blog
post](https://www.chris-kipp.io/blog/an-intro-to-flow-fields-in-scala) as well
as the examples that will be shown during the talk at [ScalaDays](https://scaladays.org/madrid-2023/) in Madrid.

## What's needed

- [scala-cli](https://scala-cli.virtuslab.org/)

## How to run

Inside of each numbered Scala file you'll see a main method. Each one
corresponds to an image in the blog post. For example to run the first one via
the command line you can do the following:

```sh
scala-cli run -M runOne .
```

If you don't include the `-M runOne` you'll instead be prompted which main
method you'd like to run. When ran you should see a window pop up with the
generated image.
