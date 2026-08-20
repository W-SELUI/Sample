figure

plot(insertion.Size,insertion.Best,'-o')
hold on

plot(bubble.Size,bubble.Best,'-o')

plot(merge.Size,merge.Best,'-o')

plot(builtin.Size,builtin.Best,'-o')

xlabel('Dataset Size')
ylabel('Best Runtime (ns)')

title('Best Runtime vs Dataset Size')

legend('Insertion','Bubble','Merge','Built-In')

grid on