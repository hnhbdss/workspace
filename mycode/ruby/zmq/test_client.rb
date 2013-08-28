require 'zmq'

context = ZMQ::Context::new

socket = context.socket(ZMQ::REQ)

socket.connect("tcp://127.0.0.1:5000")

for i in 1..10
  msg = "msg %s" % i
  socket.send(msg)
  print "Sending ", msg, "\n"
  msg_in = socket.recv
  print "Received ", msg, "\n"
end
