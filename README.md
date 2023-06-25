# An intro to Flow Fields in Scala

This repo holds the code necessary to run the examples in [this blog
post](https://www.chris-kipp.io/blog/an-intro-to-flow-fields-in-scala) as well
as the examples that will be shown during the talk at [Scala in the
City](https://www.meetup.com/scala-in-the-city/events/292844959/) in London.

## What's needed

- [scala-cli](https://scala-cli.virtuslab.org/)

## How to run

Inside of [`project.scala`](./project.scala) you'll see multiple different main
methods. Each one corresponds to an image in the blog post. For example to run
the first one via the command line you can do the following:

```sh
scala-cli run -M runOne .
```

If you don't include the `-M runOne` you'll instead be prompted which main
method you'd like to run. When ran you should see a window pop up with the
generated image.
