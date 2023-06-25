import processing.core
import processing.core.*
import processing.core.PApplet
import scala.math.Pi
import scala.math.cos
import scala.math.sin

class Four extends PApplet:
  // The actual size of our canvas
  val Width = 1000
  val Height = 1000

  // The actual size we'll work with for our flows with extra margin
  val leftX = (Width * -0.5).toInt
  val rightX = (Width * 1.5).toInt
  val topY = (Height * -0.5).toInt
  val bottomY = (Height * 1.5).toInt

  // The resolution, which will impact how many cols and rows are on the canvas
  val resolution = (Width * 0.01).toInt

  val numCols = (rightX - leftX) / resolution
  val numRows = (bottomY - topY) / resolution
  val grid = Array.ofDim[Double](numCols, numRows)

  override def settings(): Unit =
    size(Width, Height)

  override def draw(): Unit =
    background(255)

    for col <- 0 until numCols do
      for row <- 0 until numRows do
        val scaledX = col * 0.005
        val scaledY = row * 0.005
        // We switch this here to return the angle with perlin noise
        val angle = noise(scaledX.toFloat, scaledY.toFloat) * Pi * 2
        grid(col)(row) = angle

    for col <- 0 until numCols do
      for row <- 0 until numRows do
        drawLine(
          col * resolution,
          row * resolution,
          grid(col)(row),
          resolution - 2
        )

    var x: Double = 500
    var y: Double = 100
    val stepLength = 10
    val steps = 300

    for step <- 0 until steps do
      drawPoint(x, y)
      val xOffset: Double = x - leftX
      val yOffset: Double = y - topY

      val columnIndex: Int = (xOffset / resolution).toInt
      val rowIndex: Int = (yOffset / resolution).toInt

      if (columnIndex > 0 && columnIndex < grid.length)
        && (rowIndex > 0 && rowIndex < grid(columnIndex).length)
      then
        val gridAngle: Double = grid(columnIndex)(rowIndex)

        val xStep: Double = stepLength * cos(gridAngle)
        val yStep: Double = stepLength * sin(gridAngle)

        x += xStep
        y += yStep

  end draw

  def drawPoint(x: Double, y: Double): Unit =
    val baseWeight = g.strokeWeight
    val baseStroke = g.strokeColor
    stroke(255, 0, 0)
    strokeWeight(10)
    point(x.toFloat, y.toFloat)
    strokeWeight(baseWeight)
    stroke(baseStroke)

  /** Given x and y coordinates we "GOTO" that part of the grid and then draw an
    * arrow showing the given angle.
    */
  def drawLine(x: Double, y: Double, angle: Double, len: Double): Unit =
    pushMatrix()
    translate(x.toFloat, y.toFloat)
    rotate(angle.toFloat)

    val arrowSize = 2
    val lineLength = len.toFloat - arrowSize
    line(0, 0, lineLength, 0)

    triangle(
      lineLength,
      0,
      lineLength - arrowSize,
      (arrowSize / 2).toFloat,
      lineLength - arrowSize,
      (-arrowSize / 2).toFloat
    )

    popMatrix()
end Four
